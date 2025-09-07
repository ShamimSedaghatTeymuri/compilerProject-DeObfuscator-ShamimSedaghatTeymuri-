#include <stdio.h>
int func0(int value){
    int number = 1;
    for (int number2 = 1; (number2 <= value); number2 = (number2 + 1)) {
        number = (number * number2);
}
    return number;
}
int main(){
    int number3 = 4;
    int func0Result = func0(number3);
    printf("%d\n", func0Result);
    return 0;
}
