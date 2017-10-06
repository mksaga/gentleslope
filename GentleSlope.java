public class GentleSlope {
    
    public static void drawPattern(double x, double y, double size){
        
        double yMax = y + size / 2;
        double yMin = y - size / 2;
        double xMax = x + size / 2;
        double xMin = x - size / 2;
        
        int chooseRed = (int) (Math.random() * 255);
        int chooseBlue = (int) (Math.random() * 255);
        int chooseGreen = (int) (Math.random() * 255);
        
        //PennDraw.setPenColor(chooseRed, chooseBlue, chooseGreen);
        
        PennDraw.setPenColor(PennDraw.BLACK);
        //coordinate axes
        PennDraw.line(x - size / 2, y, x + size / 2, y);
        PennDraw.line(x, y + size / 2, x, y - size / 2);
        
        //draws pattern on quadrant 1-4
        
        for (int i = 0; i < 10; i++) {
            PennDraw.line(x, yMax - i * (size / 20), x + (i + 1) * (size / 20), y);
            PennDraw.line(x, yMax - i * (size / 20), x - (i + 1) * (size / 20), y);
            PennDraw.line(x - i * (size / 20), y, x, yMin + i * (size / 20));
            PennDraw.line(x + i * (size / 20), y, x, yMin + i * (size / 20));
            
            PennDraw.advance();
        }
    }
    
    public static void draw(int n, double x, double y, double size){
       
        if (n == 0) return;
        double ratio = size / 2;
        //draw initial pattern
        drawPattern(x, y, size);
        
        double xL = x - size / 2;
        double xR = x + size / 2;
        double yU = y + size / 2;
        double yL = y - size / 2;
        
        draw(n - 1, xR, yU, ratio);
        draw(n - 1, xR, yL, ratio);
        draw(n - 1, xL, yL, ratio);
        draw(n - 1, xL, yU, ratio);
        
        /*
        //first draw the bottom left subtree
        draw(n - 1, x0, y0, size / 2);
        //then draw the top left subtree
        draw(n - 1, x0, y1, size / 2);        
    
        
        //then the bottom right subtree
        draw(n - 1, x1, y0, size / 2);
        //finish up with the top right subtree
        draw(n - 1, x1, y1, size / 2);
        */
    }
    
    public static void main(String[] args) {
        
        // System.out.println("Hi there!");
        int N = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5;   // center of H-tree
        //double size = (double) 1 / N;         // side length of H-tree
        double size = 0.5;
        
        PennDraw.enableAnimation(144);
        draw(N, x, y, size);
        
        /* to draw patterns recursively atop each other
        
        double size;
        for (int i = 1; i <= N; i++) {
            size = (double) 1 / i;
            draw(i, x, y, size);
        }
        
        */
    
    }
                               
}