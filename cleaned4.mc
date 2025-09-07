int func0(int value){
    return (value * value);
}
int main(){
    int product = (6 * 4);
    int func0Result = func0(product);
    int intValue = product;
    int intValue2 = func0Result;
    printf("%d\n", func0Result);
    return 0;
}

