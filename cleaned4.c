#include <stdio.h>
int func0(int value){
    return (value * value);
}
int main(){
    int product = (6 * 4);
    int func0Result = func0(product);
    int diff = (product - func0Result);
    printf("%d\n", diff);
    return 0;
}
