**Step 3: Create a dashboard for energy consumption data (15.12.2023-12.01.2024)**

*Task A:*

1. Make a (simple) Dashboard to visualise your energy data in a meaningful (or experimental) way using https://d3js.org/.
2. You can use a "standard" timeline, but we highly encourage you to be creative! (see also the d3js examples on https://observablehq.com/@d3/gallery).

*Task B:*

1. We have the following situation: The territory of Europe (excluding the Russian Federation) has 3 time zones – Western European Time or GMT (Portugal, UK, Ireland and Island), 
Central European Time or GMT+1 (most Central European countries); and Eastern European Time or GMT+2 (Finland, Estonia, Latvia, Lithuania, Belarus, Ukraine, Moldova, Romania, 
Bulgaria, Greece, Turkey, Cyprus).

2. This creates a complication: When collecting data from the EU Member States, local energy consumption data may potentially fall into different time zones. 
A European dataspace must be time zone aware, to be able to represent data unambiguously. If you live in Brussels with a holiday house in Portugal and Estonia, 
you will have a challenge unifying energy consumption data for the same time slice.

3. Solve this complication in the following way:
   1. Identify the time zone of your country’s energy consumption data (or the one assigned to your group).
   2. Import and store the data in a time zone aware format. Make use of standards.
   3. Use the same consumption data set but imagine that it’s the data from different time zones as
   well. (e.g. holiday house or apartment in the other countries).
   4. For example: If it’s 01:00 AM in Vienna GMT+1 it’s 02:00 AM in Tallinn GMT+2. Therefore, 
   different data points are highlighted within those time gaps
   5. Extend your dashboard with a simple user interface and visualize the time zone differences 
   within the data. 

   *Submit your code as a HTML file to Gitlab for this step (no submission required on Moodle).*

===========================================================================

To Run Spring Boot application. 
Visit http://localhost:8080/dashboard in the web browser to see the energy data dashboard.

This example provides a basic setup. Depending on the specific requirements and 
the data visualization libraries you want to use, you may need to extend this example further. 
Consider using JavaScript libraries like Chart.js or D3.js for more advanced and interactive 
visualizations on the frontend.

![Graphic for the project](https://github.com/invzbl3/EnergyDashboard/assets/24904825/9da0970e-eb37-4c1e-811c-d13799314b87)
