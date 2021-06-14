import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import javax.swing.JFrame;

public class gui {

    private JPanel board;
    private final Square[][] c1squares = new Square[10][10];

    gui() {
        initializeGui();
    }

    public final void initializeGui() {

        for (int i = 0; i < c1squares.length; i++) {
            for (int j = 0; j < c1squares[i].length; j++) {

                Square square = new Square();

                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.BLACK);
                }

                c1squares[i][j] = square;
            }
        }

        board = new BoardPanel(c1squares);
        board.setBorder(new EmptyBorder(5, 5, 5, 5));

    }

    public final JComponent getGui() {
        return board;
    }

    private class BoardPanel extends JPanel {

        Square[][] squares;

        public BoardPanel(final Square[][] squares) {

            this.squares = squares;

        }

        @Override
        public void paintComponent(final Graphics g) {

            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();

            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {

                    Square currentSquare = squares[i][j];

                    System.out.println("Managing square " + i + "  " + j);

                    g.setColor(currentSquare.getBackground());
                    g.fillRect(i * width / squares.length, j * height / squares.length, width / squares.length,
                            height / squares.length);

                }
            }

        }

    }

    private class Square {

        boolean isSelected;
        Color background;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(final boolean isSelected) {
            this.isSelected = isSelected;
        }

        public Color getBackground() {
            return background;
        }

        public void setBackground(final Color background) {
            this.background = background;
        }

    }

    public static void main(final String[] args) {
        gui gb = new gui();
        JFrame frame = new JFrame("Battleship - Server");
        JComponent board = gb.getGui();
        frame.add(board);
        frame.setLocationByPlatform(true);
        //frame.setMinimumSize(frame.getSize());
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        //frame.setPreferredSize(new Dimension(100, 100));
        board.setMinimumSize(new Dimension(100, 100));
        board.setPreferredSize(new Dimension(100, 100));
        frame.setMinimumSize(new Dimension(100, 100));
        frame.setLocation(50, 50);
        frame.pack();
        frame.setVisible(true);
    }
}