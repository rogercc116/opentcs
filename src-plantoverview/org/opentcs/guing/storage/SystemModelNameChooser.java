/**
 * (c): IML, IFAK.
 *
 */
package org.opentcs.guing.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Benutzeroberfläche zum Laden und Speichern von Fahrkursmodellen.
 *
 * @author Sebastian Naumann (ifak e.V. Magdeburg)
 */
public class SystemModelNameChooser
		extends JPanel {

	/**
	 * Das Listenmodell.
	 */
	protected DefaultListModel fListModel;
	/**
	 * Die vorhandenen Fahrkursmodelle.
	 */
	protected ArrayList fModelNames;

	/**
	 * Creates new form SystemModelNameChooser
   * @param modelNames
	 */
	public SystemModelNameChooser(ArrayList modelNames) {
		fModelNames = modelNames;
		initComponents();

		fListModel = new DefaultListModel();
		modelsList.setModel(fListModel);
		updateList();

		ListSelectionModel selectionModel = modelsList.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

      @Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					return;
				}

				handleListSelection(modelsList.getSelectedIndex());
			}
		});

		handleListSelection(-1);
	}

	/**
	 * Behandelt das Ereignis, dass ein Element in der Liste selektiert wurde.
   * @param selectedIndex
	 */
	protected final void handleListSelection(int selectedIndex) {
		if (selectedIndex == -1) {
			choosenModelTextField.setText("");
		}
		else {
			choosenModelTextField.setText(modelsList.getSelectedValue().toString());
		}
	}

	/**
	 * Aktualisiert die Liste mit den Layoutnamen.
	 */
	protected final void updateList() {
		fListModel.clear();
		Collections.sort(fModelNames);
    Iterator iModels = fModelNames.iterator();

		while (iModels.hasNext()) {
			fListModel.addElement(iModels.next());
		}
	}

	/**
	 * Liefert den Namen des ausgewählten Fahrkursmodells.
   * @return 
	 */
	public String getChoosenName() {
		return choosenModelTextField.getText();
	}
	
	/**
	 * 
	 * @return 
	 */
	public boolean nameExists() {
		String choosenName = getChoosenName();
		
		return fModelNames.contains(choosenName);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        modelsLabel = new javax.swing.JLabel();
        modelsScrollPane = new javax.swing.JScrollPane();
        modelsList = new javax.swing.JList();
        choosenModelLabel = new javax.swing.JLabel();
        choosenModelTextField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        modelsLabel.setFont(modelsLabel.getFont());
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/opentcs/guing/res/labels"); // NOI18N
        modelsLabel.setText(bundle.getString("systemModelNameChooser.label.models")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(modelsLabel, gridBagConstraints);

        modelsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        modelsScrollPane.setViewportView(modelsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        add(modelsScrollPane, gridBagConstraints);

        choosenModelLabel.setFont(choosenModelLabel.getFont());
        choosenModelLabel.setText(bundle.getString("systemModelNameChooser.label.name")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 0);
        add(choosenModelLabel, gridBagConstraints);

        choosenModelTextField.setAlignmentX(1.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(choosenModelTextField, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel choosenModelLabel;
    private javax.swing.JTextField choosenModelTextField;
    private javax.swing.JLabel modelsLabel;
    private javax.swing.JList modelsList;
    private javax.swing.JScrollPane modelsScrollPane;
    // End of variables declaration//GEN-END:variables
}
