// Function to visualize data using D3.js
function visualizeData(data) {
    // Your D3.js visualization code goes here
    const svg = d3.select('#visualization');

    // Clear previous content
    svg.selectAll('*').remove();

    // Define chart dimensions
    const margin = { top: 20, right: 20, bottom: 50, left: 50 };
    const width = +svg.attr('width') - margin.left - margin.right;
    const height = +svg.attr('height') - margin.top - margin.bottom;

    // Define scales
    const xScale = d3.scaleBand()
        .domain(data.map(d => d.hora))
        .range([margin.left, width - margin.right])
        .padding(0.1);

    const yScale = d3.scaleLinear()
        .domain([0, d3.max(data, d => d.consumo_kwh)])
        .range([height - margin.bottom, margin.top]);

    // Define line function
    const line = d3.line()
        .x(d => xScale(d.hora) + xScale.bandwidth() / 2)
        .y(d => yScale(d.consumo_kwh));

    // Append line to SVG
    svg.append('path')
        .datum(data)
        .attr('fill', 'none')
        .attr('stroke', 'steelblue')
        .attr('stroke-width', 2)
        .attr('d', line);

    // Append axes
    svg.append('g')
        .attr('transform', `translate(0,${height - margin.bottom})`)
        .call(d3.axisBottom(xScale));

    svg.append('g')
        .attr('transform', `translate(${margin.left},0)`)
        .call(d3.axisLeft(yScale));
}

// Fetch XML data and visualize using D3.js
fetch('daily_consumption.xml')
    .then(response => response.text())
    .then(xmlString => {
        // Parse XML data
        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(xmlString, 'text/xml');
        const consumos = xmlDoc.querySelectorAll('consumos');

        // Extract data from XML nodes
        const data = Array.from(consumos).map(consumo => ({
            hora: consumo.querySelector('Hora').textContent,
            consumo_kwh: parseFloat(consumo.querySelector('Consumo_kWh').textContent.replace(',', '.'))
        }));

        // Call function to visualize the data using D3.js
        visualizeData(data);
    })
    .catch(error => {
        console.error('Error fetching or parsing XML data:', error);
    });
