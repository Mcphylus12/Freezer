package softwareproject.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.util.Date;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import softwareproject.model.Activity;
import softwareproject.model.Assessment;
import softwareproject.model.Exam;
import softwareproject.model.Milestone;
import softwareproject.model.Module;
import softwareproject.model.StudyTask;

/**
 *
 * @author qxz14sru
 */
public class GanttChartWindow extends JFrame{
    
    
    Module m;
    
    public GanttChartWindow(Date startDate, Date endDate, Module m){
        super("Gantt chart");
        this.m = m;
        
        IntervalCategoryDataset dataset = createDataset();
        
        JFreeChart chart = createChart(dataset);
        
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        
        MyGanttRenderer renderer = new MyGanttRenderer();
        plot.setRenderer(renderer);
        
        renderer.setMaximumBarWidth(0.1);
        renderer.setMinimumBarLength(0.2);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        this.setContentPane(chartPanel);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }
    
    public IntervalCategoryDataset createDataset(){
        
        TaskSeries series = new TaskSeries("");
        TaskSeriesCollection coll = new TaskSeriesCollection();
        
        for(Assessment assess: m.getAssessments()){
            Task taskGroup = null;
            if(assess instanceof Exam){
                //if the assessment is an exam the due date will be the start time of the exam and needs to come before
                //setdate which is the due date + duration
                taskGroup = new Task(assess.getName(), new SimpleTimePeriod(assess.getDueDate(), assess.getSetDate()));
            }else{
                taskGroup = new Task(assess.getName(), new SimpleTimePeriod(assess.getSetDate(), assess.getDueDate()));
            }
            series.add(taskGroup);
            
            for(StudyTask task: assess.getTasks()){
                Task studyTask = new Task(task.getTitle(), new SimpleTimePeriod(task.getStartDate(), task.getEndDate()));
                int tally = 0;
                for(Activity act: task.getActivities()){
                    if(act.getIsFinished()){
                        tally += act.getHours();
                    }
                }
                studyTask.setPercentComplete(((double)tally)/((double)task.getHours()));
                series.add(studyTask);
            }
            
            for(Activity activity: assess.getActivities()){
                Task activ = new Task(activity.getName(), new SimpleTimePeriod(activity.getStartDate(), activity.getStartDate()));
                series.add(activ);
            }
            
            for(Milestone milestone: assess.getMilestones()){
                Task mile = new Task(milestone.getTitle(), new SimpleTimePeriod(milestone.getStartDate(), milestone.getDeadline()));
                series.add(mile);
            }
        }
        coll.add(series);
        return coll;
    }
    
    public JFreeChart createChart(IntervalCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createGanttChart(m.getModuleName(), "Assessment", "Date", dataset, false, true, false);
        return chart;
    }
    
}

class MyGanttRenderer extends GanttRenderer {
    public MyGanttRenderer() {
        super();
    }

    @Override
    public Paint getItemPaint(int row, int column) {
        return Color.BLUE;
    }
}
