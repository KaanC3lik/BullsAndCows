class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        // write your code here
        StringBuilder stringBuilder = new StringBuilder();
        char a;
        for (int i = 65; i <= 90; i++) {
            a = (char) i;
            if (i == 90) {
                stringBuilder.append(a);
            }else {
                stringBuilder.append(a).append(" ");
            }
        }
        return stringBuilder;
    }
}