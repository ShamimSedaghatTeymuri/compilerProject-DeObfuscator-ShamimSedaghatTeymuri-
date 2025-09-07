#include <stdio.h>
int func0(int value){
    int number = 0;
    int number2 = 1;
    while ((number2 <= value)) {
        if (((number2 % 2) == 0)) {
            number = (number + number2);
}
        number2 = (number2 - 1);
}
    return number;
}
int main(){
    int number3 = 10;
    int func0Result = func0(number3);
    printf("%d\n", func0Result);
    return 0;
}
