let chartDataStr = decodeHtml(chartData);
let chartJsonArray = JSON.parse(chartDataStr);

let arrayLength = chartJsonArray.length;
let numericData = [];
let labelData = [];

for (let i=0; i < arrayLength; i++){
    numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray.label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f" ],
            data: numericData
        }]
    },
    options: {
        title:{
            display: true,
            text: 'Project Status'
        }
    }
});


function decodeHtml(html){
    let txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}