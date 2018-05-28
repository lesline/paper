package eight;

class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    String testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
        return stringConverter1.convert(1);

    }

    public static void main(String[] args) {
        Lambda4 lambda4=new Lambda4();

        System.out.println(lambda4.outerNum);
        lambda4.testScopes();
        System.out.println(lambda4.outerNum);

        lambda4.outerNum=5;
        System.out.println(lambda4.outerNum);


    }

}