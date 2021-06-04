package servlet.shout;

public class xiangjia {
           private   int  number ;

            public int getNumber() {
                int  numbers = 0;
                for (int i = 0; i < this.number; i++) {
                              numbers=numbers+i ;

                }
                return numbers;
    }

        public void setNumber(int number) {
                if (number==0){
                      this.number=10;
                }
                this.number = number;
        }
        public  void  showNumber(){
            int number = getNumber();
            if(number>100){
                System.out.println("最终的数字为"+number);
            }else {
                System.out.println("你的数字有点小呀");

            }

            }


}
