let plusOneNr = 1
let hideTextNr = 1
let codingStuff = ["C", "C#", "C++", "Java", "Python", ".NET", "JavaScript", "PHP", "SQL"]


function plusOne(){
    plusOneNr += 1
    document.getElementById("startNr").innerHTML = plusOneNr;
}

function hideText(){
    hideTextNr += 1

    if (hideTextNr%2 === 0) {
        document.getElementById("button2").innerHTML = "Show Text"
        document.getElementById("hideText").style.display = "none";
    } else {
        document.getElementById("button2").innerHTML = "Hide Text"
        document.getElementById("hideText").style.display = "block";
    }
}

function randomWords() {
    document.getElementById("button3").innerHTML = "Add More Words"
    let ul = document.getElementById("wordList");
    let li = document.createElement("li");
    li.appendChild(document.createTextNode(codingStuff[Math.floor(Math.random()*8)]));
    ul.appendChild(li);
}