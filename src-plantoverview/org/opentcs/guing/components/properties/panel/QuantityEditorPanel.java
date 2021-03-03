/**
 * (c): IML, IFAK.
 *
 */
package org.opentcs.guing.components.properties.panel;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import org.opentcs.guing.components.dialogs.DetailsDialogContent;
import org.opentcs.guing.components.properties.type.AbstractQuantity;
import org.opentcs.guing.components.properties.type.Property;
import org.opentcs.guing.model.SystemModel;
import org.opentcs.guing.util.ResourceBundleUtil;

/**
 * Ein Panel, mit dem ein Zahlenwert und eine Ma�einheit editiert werden k�nnen.
 *
 * @author Sebastian Naumann (ifak e.V. Magdeburg)
 */
public class QuantityEditorPanel
    extends JPanel
    implements DetailsDialogContent {

  /**
   * This class's logger.
   */
  private static final Logger log
      = Logger.getLogger(QuantityEditorPanel.class.getName());
  /**
   * Das Property, auf das der Panel zugreift.
   */
  private AbstractQuantity<?> fProperty;

  /**
   * Creates new form QuantityEditorPanel
   */
  public QuantityEditorPanel() {
    initComponents();
  }

  @Override
  public String getTitle() {
    return ResourceBundleUtil.getBundle().getString("QuantityEditorPanel.title");
  }

  /**
   * Richtet die Dialogelemente entsprechend den Eigenschaftswerten ein. Diese
   * Methode wird aufgerufen, wenn der Dialog ge�ffnet wird.
   */
  public void initFields() {
    unitComboBox.setSelectedItem(fProperty.getUnit());

    String value;

    if (fProperty.isInteger()) {
      value = Integer.toString((int) fProperty.getValue());
    }
    else if (fProperty.getValue() instanceof Double) {
      value = Double.toString((double) fProperty.getValue());
    }
    else {
      value = fProperty.getValue().toString();
    }

    numberTextField.setText(value);
  }

  @Override
  public void updateValues() {
    try {
      double value = Double.parseDouble(numberTextField.getText());
      String unit = unitComboBox.getSelectedItem().toString();
      fProperty.setValueAndUnit(value, unit);
    }
    catch (NumberFormatException nfe) {
      // Don't parse String "<different values>"
    }
    catch (IllegalArgumentException e) {
      log.log(Level.SEVERE, "Exception: ", e);
    }
  }

  @Override
  public void setProperty(Property property) {
    fProperty = (AbstractQuantity<?>) property;
    unitComboBox.setModel(new DefaultComboBoxModel(fProperty.getPossibleUnits().toArray()));
    initFields();
  }

  @Override
  public AbstractQuantity<?> getProperty() {
    return fProperty;
  }

  @Override
  public void setSystemModel(SystemModel systemModel) {
    // Do nada.
  }

  // CHECKSTYLE:OFF
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        numberTextField = new javax.swing.JTextField();
        unitComboBox = new javax.swing.JComboBox();

        setLayout(new java.awt.GridBagLayout());

        numberTextField.setColumns(10);
        numberTextField.setFont(numberTextField.getFont());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(numberTextField, gridBagConstraints);

        unitComboBox.setFont(unitComboBox.getFont());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(unitComboBox, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField numberTextField;
    private javax.swing.JComboBox unitComboBox;
    // End of variables declaration//GEN-END:variables
  // CHECKSTYLE:ON
}
