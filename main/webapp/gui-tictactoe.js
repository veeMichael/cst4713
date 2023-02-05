
 (function (calculateWinner) {

    const x = document.querySelectorAll("#tictactoe tbody td");
    tds = [...x];
    let isX = true;
    let isWinner = false;
    const message = document.getElementById("message");
    const btnReset = document.getElementById("btnReset");   
    
    tds.forEach( td => {

        td.addEventListener("click", () => {    
            play(td);
        });
    })

    function reset(){
        tds.forEach( e => {
            e.innerText = "N" ;
            e.classList.remove("winner");

        });
        message.innerText = "";
        isWinner = false;
    }

    btnReset.addEventListener("click", reset );

    function play(pThis) {

        if (isWinner){
            message.innerText = "You won already, what are you doing?";
            return;
        }



        message.innerText = "";
        if (pThis.innerText != "N"){
            message.innerText = "Stop Cheating!";
            return;
        }

        console.log("playing");
        pThis.innerText = isX ? "X" : "O";
        isX = !isX;

        
        const data = tds.map( td => td.innerText);
        let status = calculateWinner(data);




        if (status.isWinner){



            let [p1,p2,p3] = status.winningCombo;
            tds[p1].classList.add("winner");
            tds[p2].classList.add("winner");
            tds[p3].classList.add("winner");
            if(status.whoWon=="X"){
                message.innerText = "There winner is X";
              } 
              else{
                message.innerText = "There winner is O";
              }
            isWinner = true;
        }


    }
 })(window.citytech.getWinner)