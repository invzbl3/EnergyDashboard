// Fetch data from backend endpoint
fetch('your_data_endpoint')
    .then(response => response.text())
    .then(xmlString => {
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

// Function to visualize data using D3.js
function visualizeData(data) {
    const svg = d3.select('#visualization');

    // Clear previous content
    svg.selectAll('*').remove();

    // Define chart dimensions and scales
    // Add D3.js code to create the visualization (e.g., line chart or bar chart)
}