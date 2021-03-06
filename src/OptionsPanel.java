
import com.jogamp.opengl.GLContext;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author karma
 */
public class OptionsPanel extends javax.swing.JPanel {
	
	public String fileName;
	public Renderer rend;
	public Sprite2D sprite;
	
	/**
	 * Creates new form OptionsPanel
	 */
	public OptionsPanel() {
		
		initComponents();
	}
	
	public void setSprite(Sprite2D sprite) {
		
		this.sprite = sprite;
	}

	/**
	 * if a filename argument has been set this allows this class access to it
	 * @param s a file name passed as a cmd line argument
	 */
	public void setFileName(String s) {
		
		fileName = s;
	}
	
	/**
	 * give this class access to the opengl renderer
	 * @param rend the opengl renderer
	 */
	public void setRenderer(Renderer rend) {
		
		this.rend = rend;
	}
	
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                java.awt.GridBagConstraints gridBagConstraints;

                TexturePanel = new javax.swing.JPanel();
                jButton1 = new javax.swing.JButton();
                jImagePanel1 = new JImagePanel();
                jCheckBox1 = new javax.swing.JCheckBox();
                SpriteOptionsPanel = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                widthSpinner = new javax.swing.JSpinner();
                heightSpinner = new javax.swing.JSpinner();
                jLabel3 = new javax.swing.JLabel();
                scaleSpinnerX = new javax.swing.JSpinner();
                jLabel4 = new javax.swing.JLabel();
                posSpinnerX = new javax.swing.JSpinner();
                jLabel5 = new javax.swing.JLabel();
                posSpinnerY = new javax.swing.JSpinner();
                jLabel6 = new javax.swing.JLabel();
                indexSpinner = new javax.swing.JSpinner();
                jLabel7 = new javax.swing.JLabel();
                scaleSpinnerY = new javax.swing.JSpinner();
                AnimationOptionsPanel = new javax.swing.JPanel();
                jCheckBox2 = new javax.swing.JCheckBox();
                addFrameSpinner = new javax.swing.JSpinner();
                jButton2 = new javax.swing.JButton();
                jComboBox1 = new javax.swing.JComboBox<>();
                jButton3 = new javax.swing.JButton();
                jLabel10 = new javax.swing.JLabel();
                jSpinner1 = new javax.swing.JSpinner();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();

                setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
                setLayout(new java.awt.GridBagLayout());

                TexturePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Texture", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
                TexturePanel.setLayout(new java.awt.GridBagLayout());

                jButton1.setText("Select Texture");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
                TexturePanel.add(jButton1, gridBagConstraints);

                jImagePanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                jImagePanel1.setDoubleBuffered(true);
                jImagePanel1.setMinimumSize(new java.awt.Dimension(150, 150));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                TexturePanel.add(jImagePanel1, gridBagConstraints);

                jCheckBox1.setText("SDF Texture");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
                TexturePanel.add(jCheckBox1, gridBagConstraints);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
                add(TexturePanel, gridBagConstraints);
                TexturePanel.getAccessibleContext().setAccessibleDescription("");

                SpriteOptionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Sprite Options", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
                SpriteOptionsPanel.setLayout(new java.awt.GridBagLayout());

                jLabel1.setText("Width:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(jLabel1, gridBagConstraints);

                jLabel2.setText("Height:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(jLabel2, gridBagConstraints);

                widthSpinner.setModel(new javax.swing.SpinnerNumberModel(128, 0, null, 1));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.ipadx = 20;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(widthSpinner, gridBagConstraints);

                heightSpinner.setModel(new javax.swing.SpinnerNumberModel(128, 0, null, 1));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(heightSpinner, gridBagConstraints);

                jLabel3.setText("Scale X:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(jLabel3, gridBagConstraints);

                scaleSpinnerX.setModel(new javax.swing.SpinnerNumberModel(64, null, null, 1));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(scaleSpinnerX, gridBagConstraints);

                jLabel4.setText("Position X:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(jLabel4, gridBagConstraints);

                posSpinnerX.setModel(new javax.swing.SpinnerNumberModel());
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(posSpinnerX, gridBagConstraints);

                jLabel5.setText("Position Y:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(jLabel5, gridBagConstraints);

                posSpinnerY.setModel(new javax.swing.SpinnerNumberModel());
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(posSpinnerY, gridBagConstraints);

                jLabel6.setText("Index:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 6;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(jLabel6, gridBagConstraints);

                indexSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 6;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(indexSpinner, gridBagConstraints);

                jLabel7.setText("Scale Y:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(jLabel7, gridBagConstraints);

                scaleSpinnerY.setModel(new javax.swing.SpinnerNumberModel(64, null, null, 1));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                SpriteOptionsPanel.add(scaleSpinnerY, gridBagConstraints);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
                add(SpriteOptionsPanel, gridBagConstraints);

                AnimationOptionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Animation Options", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
                AnimationOptionsPanel.setLayout(new java.awt.GridBagLayout());

                jCheckBox2.setText("Enable animation");
                jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jCheckBox2ActionPerformed(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridwidth = 2;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                AnimationOptionsPanel.add(jCheckBox2, gridBagConstraints);

                addFrameSpinner.setModel(new javax.swing.SpinnerNumberModel());
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.ipadx = 20;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                AnimationOptionsPanel.add(addFrameSpinner, gridBagConstraints);

                jButton2.setText("Add Frame");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                AnimationOptionsPanel.add(jButton2, gridBagConstraints);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                AnimationOptionsPanel.add(jComboBox1, gridBagConstraints);

                jButton3.setText("Remove Frame");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                AnimationOptionsPanel.add(jButton3, gridBagConstraints);

                jLabel10.setText("Speed (fps):");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                AnimationOptionsPanel.add(jLabel10, gridBagConstraints);

                jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                AnimationOptionsPanel.add(jSpinner1, gridBagConstraints);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
                add(AnimationOptionsPanel, gridBagConstraints);

                jLabel8.setText("Version 1.1");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = 3;
                add(jLabel8, gridBagConstraints);

                jLabel9.setText("Coded by: Joshua Lambert");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = 4;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
                gridBagConstraints.weighty = 1.0;
                add(jLabel9, gridBagConstraints);
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                
		JFileChooser open = new JFileChooser();
		FileNameExtensionFilter ff = new FileNameExtensionFilter("Images", "png", "jpg");
		open.setFileFilter(ff);
		open.setCurrentDirectory(new File("."));
		
		int res = open.showOpenDialog(this);
				
		if (res == JFileChooser.APPROVE_OPTION) {
			
			File file = open.getSelectedFile();
			
			try {
				
				BufferedImage img = ImageIO.read(file);
				jImagePanel1.setImage(img.getScaledInstance(150, 150, Image.SCALE_DEFAULT));
				jImagePanel1.paintComponent(jImagePanel1.getGraphics());
				//a new context is needed or else it the loadTexture functions fails
				GLContext con = rend.glAutoDrawable.getContext();
				con.makeCurrent();
				rend.loadTexture(file.getAbsolutePath());
				
			} catch (IOException ex) {
				
				String s = "error opening " + open.getName(file);
				JOptionPane.showMessageDialog(this, s);
			}
		}
        }//GEN-LAST:event_jButton1ActionPerformed

        private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_jCheckBox2ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                
		if (sprite != null) {
			
			int num = jComboBox1.getItemCount();
			int[] newFrames = new int[num + 1];

			for (int i = 0; i < num; i++) {

				newFrames[i] = jComboBox1.getItemAt(i);
			}
			
			newFrames[num] = (int) addFrameSpinner.getValue();
			jComboBox1.addItem((int) addFrameSpinner.getValue());
			sprite.frames = newFrames;
		}
        }//GEN-LAST:event_jButton2ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		
		if (sprite != null) {
			
			jComboBox1.removeItemAt(jComboBox1.getSelectedIndex());
			
			int num = jComboBox1.getItemCount();
			int[] newFrames = new int[num];

			for (int i = 0; i < num; i++) {

				newFrames[i] = jComboBox1.getItemAt(i);
			}
						
			sprite.frames = newFrames;
		}
        }//GEN-LAST:event_jButton3ActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel AnimationOptionsPanel;
        private javax.swing.JPanel SpriteOptionsPanel;
        private javax.swing.JPanel TexturePanel;
        private javax.swing.JSpinner addFrameSpinner;
        public javax.swing.JSpinner heightSpinner;
        public javax.swing.JSpinner indexSpinner;
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        public javax.swing.JCheckBox jCheckBox1;
        public javax.swing.JCheckBox jCheckBox2;
        public javax.swing.JComboBox<Integer> jComboBox1;
        public JImagePanel jImagePanel1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        public javax.swing.JSpinner jSpinner1;
        public javax.swing.JSpinner posSpinnerX;
        public javax.swing.JSpinner posSpinnerY;
        public javax.swing.JSpinner scaleSpinnerX;
        public javax.swing.JSpinner scaleSpinnerY;
        public javax.swing.JSpinner widthSpinner;
        // End of variables declaration//GEN-END:variables
}
