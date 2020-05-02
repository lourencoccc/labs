function initiate(){
    var canvasElement =  document.getElementById('canvas');
    canvas =  canvasElement.getContext('2d');

    //drawRectangles();
    applyGradientes();
}
window.addEventListener("load", initiate, false);

function drawRectangles(){

    //color for the lines of shape
    canvas.fillStyle = "#000099";
    //color for the interior of shape
    canvas.strokkeStyle = "#990000";
    //tranaparency with values between  0 and 1, the default value is 1
    canvas.globalAlpha=1;

    canvas.strokeRect(100,100,120,120);
    canvas.fillRect(110,110,100,100);
    canvas.clearRect(120,120,80,80);
}

function applyGradientes(){

    var grad = canvas.createLinearGradient(0,0,10,100);
    grad.addColorStop(0.5, '#0000FF');
    grad.addColorStop(1, '#0000A0');
    canvas.fillStyle =  grad;

    canvas.fillRect(10,10,100,100);
    canvas.fillRect(150,10,200,100);
}
