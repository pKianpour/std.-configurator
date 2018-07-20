package application;
	
import java.util.function.Function;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	public static final int X_DATA_COUNT = 2000;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		NumberAxis xAxis = new NumberAxis(0, X_DATA_COUNT, 200);
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Series 1");
		
		LineChart baseChart = new LineChart(xAxis, yAxis);
		baseChart.getData().add(prepareSeries("Series 1", (x) -> (double) x));
		
		MultipleAxesLineChart chart = new MultipleAxesLineChart(baseChart, Color.RED);
		chart.addSeries(prepareSeries("Series 2", (x) -> (double) x*x), Color.BLUE);
		chart.addSeries(prepareSeries("Series 3", (x) -> (double) -x*x), Color.GREEN);
		chart.addSeries(prepareSeries("Series 4", (x) -> ((double) (x-250))*x), Color.DARKCYAN);
		chart.addSeries(prepareSeries("Series 5", (x) -> ((double) (x+100)*(x-200))), Color.BROWN);
		chart.addSeries(prepareSeries("Series 6", (x) -> ((double) (x+1000))), Color.DARKMAGENTA);
		chart.addSeries(prepareSeries("Series 7", (x) -> ((double) Math.log((x+100)))), Color.AQUA);
		chart.addSeries(prepareSeries("Series 8", (x) -> ((double) x*x*x)), Color.BLACK);
		chart.addSeries(prepareSeries("Series 9", (x) -> ((double) x*x*x*x)), Color.BLACK);
		chart.addSeries(prepareSeries("Series 10", (x) -> ((double) x*x*x*x*x)), Color.BLACK);
		chart.addSeries(prepareSeries("Series 11", (x) -> ((double) Math.E*x)), Color.YELLOW);
		chart.addSeries(prepareSeries("Series 12", (x) -> ((double) Math.PI*x)), Color.BLACK);
		chart.addSeries(prepareSeries("Series 13", (x) -> ((double) Math.sin(x))), Color.BLACK);
		chart.addSeries(prepareSeries("Series 14", (x) -> ((double) Math.cos(x))), Color.BLACK);
		chart.addSeries(prepareSeries("Series 15", (x) -> ((double) Math.sqrt(x))), Color.CADETBLUE);
		chart.addSeries(prepareSeries("Series 16", (x) -> ((double) Math.sqrt(x*x*x))), Color.DARKORANGE);
		chart.addSeries(prepareSeries("Series 17", (x) -> ((double) Math.sqrt(x*x*x*x))), Color.INDIGO);
		chart.addSeries(prepareSeries("Series 18", (x) -> ((double) 50*x+2500)), Color.FUCHSIA);
		chart.addSeries(prepareSeries("Series 19", (x) -> ((double) (90*x*x)+(70*x)+575)), Color.GOLD);
		chart.addSeries(prepareSeries("Series 20", (x) -> ((double) Math.sqrt(x*x*x)*(50*x))), Color.LIGHTCORAL);
		
		//LineChart<Number, Number> lineChart = createChart();
		
		primaryStage.setTitle("MultipleAxesLineChart Example");
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(chart);
		borderPane.setBottom(chart.getLegend());
		
		Scene scene = new Scene(borderPane, 1920, 1080);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private XYChart.Series<Number, Number> prepareSeries(String name, Function<Integer, Double> function) {
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		series.setName(name);
		for (int i = 0; i < X_DATA_COUNT; i++)
			series.getData().add(new XYChart.Data<>(i, function.apply(i)));
		return series;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
//	public static LineChart<Number, Number> createChart() {
//		final NumberAxis xAxis = new NumberAxis(1, 25, 5);
//		final NumberAxis yAxis = new NumberAxis();
//		xAxis.setLabel("Month Number");
//		
//		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
//		lineChart.setTitle("Line Chart");
//		
//		XYChart.Series<Number, Number> series = new XYChart.Series<>();
//		series.setName("Example line");
//		series.getData().add(new XYChart.Data<Number, Number>(1, 23));
//		series.getData().add(new XYChart.Data(2, 14));
//        series.getData().add(new XYChart.Data(3, 15));
//        series.getData().add(new XYChart.Data(4, 24));
//        series.getData().add(new XYChart.Data(5, 34));
//        series.getData().add(new XYChart.Data(6, 36));
//        series.getData().add(new XYChart.Data(7, 22));
//        series.getData().add(new XYChart.Data(8, 45));
//        series.getData().add(new XYChart.Data(9, 43));
//        series.getData().add(new XYChart.Data(10, 17));
//        series.getData().add(new XYChart.Data(11, 29));
//        series.getData().add(new XYChart.Data(12, 25));
//        
//        lineChart.getData().add(series);
//        return lineChart;
//	}
}
