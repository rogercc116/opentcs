/**
 * Copyright (c) The openTCS Authors.
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */
package org.opentcs.modeleditor.application.action.view;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Objects;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opentcs.modeleditor.application.OpenTCSView;
import static org.opentcs.modeleditor.util.I18nPlantOverviewModeling.MENU_PATH;
import org.opentcs.thirdparty.guing.common.jhotdraw.util.ResourceBundleUtil;

/**
 * Actions for adding background bitmaps to the drawing view.
 *
 * @author Philipp Seifert (Fraunhofer IML)
 */
public class AddBitmapAction
    extends AbstractAction {

  /**
   * This action's ID.
   */
  public static final String ID = "view.addBitmap";

  private static final ResourceBundleUtil BUNDLE = ResourceBundleUtil.getBundle(MENU_PATH);

  private final JFileChooser fc;

  private final OpenTCSView view;

  /**
   * Creates a new instance.
   *
   * @param view The openTCS view
   */
  public AddBitmapAction(OpenTCSView view) {
    this.view = Objects.requireNonNull(view, "view");

    this.fc = new JFileChooser(System.getProperty("opentcs.home"));
    this.fc.setFileFilter(new FileNameExtensionFilter("Bitmaps (PNG, JPG, BMP, GIF)",
                                                      "png",
                                                      "jpg",
                                                      "bmp",
                                                      "gif"));
    this.fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

    putValue(NAME, BUNDLE.getString("addBitmapAction.name"));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int returnVal = fc.showOpenDialog(null);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = fc.getSelectedFile();
      view.addBackgroundBitmap(file);
    }
  }
}
