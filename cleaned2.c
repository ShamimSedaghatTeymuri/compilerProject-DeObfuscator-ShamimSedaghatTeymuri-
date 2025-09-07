#include <stdio.h>
int func0(int value, int value2){
    if ((value > value2)) {
        return value;
} else {
        return value2;
}
}
int main(){
    int number = 5;
    int number2 = 9;
    int func0Result = func0(number, number2);
    printf("%d\n", func0Result);
    return 0;
}
