function handleRawData(rawData) {

    var labelCount = rawData.length;
    var labels = createLabels(labelCount);
    var respnseRoads = getRoadNames(rawData);
    var velocityChart = createEmptyChartDataObject(labels);
    var travelTimeChart = createEmptyChartDataObject(labels);
    var startCounter = 0;

    if (labelCount > 12) {
        startCounter = labelCount -12;
    }

    for(var x=0; x<respnseRoads.length; x++) {

        // all records of same road
        var roadArray = [];
        for (var i = labelCount; i> startCounter; i--) {
            roadArray.push(rawData[i -1].specificRoads[x]);
        }
        var velocityArray = [];
        var travelTimeArray= [];

        roadArray.forEach(function(road) {
            velocityArray.push(road.velocity);
            travelTimeArray.push(road.travelTime);
        });


        var velocityDataset = createDataset(roadArray[0].road, velocityArray);
        var travelTimeDataset= createDataset(roadArray[0].road, travelTimeArray);
        appendDataSetToChartObject(velocityDataset, velocityChart);
        appendDataSetToChartObject(travelTimeDataset, travelTimeChart);
    }

    return { velocityChart: velocityChart, travelTimeChart: travelTimeChart}
}

function createDataset(roadname, dataArray) {
    return {
        label: roadname,
        fillColor : "rgba(151,187,205,0.2)",
        strokeColor : "rgba(151,187,205,1)",
        pointColor : "rgba(151,187,205,1)",
        pointStrokeColor : "#fff",
        pointHighlightFill : "#fff",
        pointHighlightStroke : "rgba(151,187,205,1)",
        data : dataArray
    }
}

function getRoadNames(rawData) {
    var roads= [];

    rawData[0].specificRoads.forEach(function(data) {
        roads.push(data.road)
    });

    return roads;
}

function getRoadsFromDatabase(rawData) {
    var roads = [];

    rawData[0].features.forEach(function(feature) {
        roads.push(feature.properties.name);
    });

    return roads;
}

function createLabels(labelCount) {
    var labels = ["now"];
    var loopCounter = 0;
    var startPoint = 0;
    if (labelCount > 12) {
        startPoint = labelCount -12;
    }

    for (var i = startPoint; i<labelCount; i++) {
        loopCounter += 5
        labels.push(loopCounter + "minuten geleden");
    }

    return labels;
}

function createEmptyChartDataObject(labels) {

    return {
        labels : labels,
        datasets: []
    }
}

function appendDataSetToChartObject(dataset, chartObject) {
    chartObject = chartObject.datasets.push(dataset);
    return chartObject;
}


