import net.ericaro.surfaceplotter.DefaultSurfaceModel;
import net.ericaro.surfaceplotter.Mapper;
import net.ericaro.surfaceplotter.surface.ArraySurfaceModel;
import net.ericaro.surfaceplotter.surface.JSurface;
import net.ericaro.surfaceplotter.surface.SurfaceModel;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        new Main();
    }

    private Main() {
        setSize(500, 500);
        setTitle("Surface plotter");

        setLayout(new BorderLayout());


        ArraySurfaceModel surface = new ArraySurfaceModel();



        float[][] data = new float[1000][1000];

        for(int x = 0;x < data.length;x++) {
            for(int y = 0;y < data[x].length;y++) {
                data[x][y] = (float)(Math.sin((x / (float)data.length) * Math.PI * 4) + Math.cos((y / (float)data.length) * Math.PI * 4));
            }
        }

        surface.setPlotType(SurfaceModel.PlotType.SURFACE);
        surface.setValues(-5, 5, -5, 5, data.length, data, null);

        add(new JSurface(surface));

        setVisible(true);
    }



}