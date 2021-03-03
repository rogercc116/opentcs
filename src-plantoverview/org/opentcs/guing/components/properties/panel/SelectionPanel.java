/**
 * (c): IML, IFAK.
 *
 */
package org.opentcs.guing.components.properties.panel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import org.opentcs.guing.components.dialogs.DetailsDialogContent;
import org.opentcs.guing.components.properties.type.Property;
import org.opentcs.guing.model.SystemModel;

/**
 * An user interface to select a value in a combobox.
 *
 * @author Sebastian Naumann (ifak e.V. Magdeburg)
 */
public class SelectionPanel
    extends JPanel
    implements DetailsDialogContent {

  /**
   * The title of the dialog.
   */
  private String fTitle;

  /**
   * Creates new SelectionPanel.
   */
  public SelectionPanel() {
    this("Titel", "Label", new ArrayList<>());
  }

  /**
   * Creates new form StringPanel.
   *
   * @param title The title.
   * @param text The text of the label.
   * @param items The selectable values.
   */
  public SelectionPanel(String title, String text, List<?> items) {
    this(title, text, items, null);
  }

  /**
   * Creates new form StringPanel.
   *
   * @param title The title.
   * @param text The text of the label.
   * @param items The selectable values.
   * @param item The value that is initially selected.
   */
  public SelectionPanel(String title, String text, List<?> items, Object item) {
    initComponents();
    label.setText(text + ":");
    fTitle = title;
    comboBox.setModel(new DefaultComboBoxModel(items.toArray()));

    if (item != null) {
      comboBox.setSelectedItem(item);
    }
  }

  /**
   * Returns the selected value.
   *
   * @return The selected value.
   */
  public Object getValue() {
    return comboBox.getSelectedItem();
  }

  /**
   * Returns the selected index.
   *
   * @return The selected index.
   */
  public int getIndex() {
    return comboBox.getSelectedIndex();
  }


  @Override
  public String getTitle() {
    return fTitle;
  }

  @Override
  public void setProperty(Property property) {
  }

  @Override
  public Property getProperty() {
    return null;
  }

  @Override
  public void updateValues() {
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

        label = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox();

        setLayout(new java.awt.GridBagLayout());

        label.setFont(label.getFont());
        label.setText("Text:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        add(label, gridBagConstraints);

        comboBox.setFont(comboBox.getFont());
        comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboBox, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBox;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
  // CHECKSTYLE:ON
}
