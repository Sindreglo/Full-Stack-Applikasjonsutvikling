const app = Vue.createApp({
    data(){
        return{
            variable1: "",
            log: [],
            reset: false,
            sum: 0
        }
    },
    methods: {

        ONE(){ 
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += 1
        },
        TWO(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += 2
        },
        THREE(){ 
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += 3
        },
        FOUR(){ 
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += 4
        },
        FIVE(){ 
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += 5
        },
        SIX(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += 6
        },
        SEVEN(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += 7
        },
        EIGHT(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += 8
        },
        NINE(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += 9
        },
        ZERO(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += 0
        },
        COMMA(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += "."
        },
        addition(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += "+"            
        },
        subtraction(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += "-"        
        },
        multiplication(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += "*"        
        },
        division(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 += "/"        
        },

        C(){
            this.variable1 = ""
        },
        ANS(){
            this.variable1 = this.sum + ""
            this.reset = false
        },
        DEL(){
            if(this.reset == true) {
                this.variable1 = ""
                this.reset = false
            }
            this.variable1 = this.variable1.substring(0, this.variable1.length - 1);
        },

        equal() {
            this.sum = eval(this.variable1)

            this.variable1 += "="
            this.variable1 += this.sum

            this.log.push(this.variable1)

            this.reset = true
            
        }

    }
})