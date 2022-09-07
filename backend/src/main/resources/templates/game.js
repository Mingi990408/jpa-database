const canvas = document.getElementById("myCanvas");
const ctx = canvas.getContext("2d");

canvas.width = window.innerWidth - 100;
canvas.height = window.innerHeight - 100;
const game = {
    x : window.innerWidth / 4,
    y : 10,
    width : window.innerWidth / 2,
    height : 240,
    draw() {
        ctx.strokeRect(this.x,this.y,this.width,this.height);
    }
}
// game.draw();
const user = {
    // x : window.innerWidth / 3,
    x : 10,
    y : 200,
    width : 50,
    height : 50,
    draw(){
        ctx.fillStyle = "green";
        ctx.fillRect(this.x,this.y,this.width,this.height);
    }
}
user.draw()
class Cactus{
    constructor() {
        // this.x = game.width + 450;
        this.x = 500;
        this.y = 200;
        this.width = 30;
        this.height = 50;
    }
    draw(){
        ctx.fillStyle = "red";
        ctx.fillRect(this.x,this.y,this.width,this.height);
    }
}

let timer = 0;
let cactus여러개 = [];
let jumptimer = 0;
let animation;

function gamestrat(){
    animation = requestAnimationFrame(gamestrat);
    timer++;

    ctx.clearRect(0,0,canvas.width,canvas.height);

    if(timer % 200 === 0){
        var cactus = new Cactus();
        cactus여러개.push(cactus);
    }

    cactus여러개.forEach((a,i,o) => {
        // x좌표가 0 미만이면 제거
        if(a.x < 0){
            o.splice(i,1)
        }
        a.x--;
        충돌확인(user,a)
         a.draw();

        if(jump == true){
            user.y--;
            jumptimer++;
        }
        if(jump == false){
            if(user.y < 200){
                user.y++;
            }
        }
        if(jumptimer > 100){
            jump = false;
            jumptimer = 0;
        }
    })
    user.draw();
}

gamestrat()

// 충돌 확인
function 충돌확인(user, cactus){
    let x축차이 = cactus.x - (user.x + user.width)
    let y축차이 = cactus.y - (user.y + user.height)
    if(x축차이 < 0 && y축차이 < 0){
        ctx.clearRect(0,0,canvas.width,canvas.height);
        cancelAnimationFrame(animation)
    }
}



let jump = false;

document.addEventListener('keydown', function (e){
    if(e.code === 'Space') {
        jump = true;
    }
})