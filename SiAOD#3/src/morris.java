public class morris {
    public String txt;
    public String str;
    public morris(String text1, String str1) {
        txt = text1;
        str = str1;
    }
    public void prefix(int[] mas) {
        if (txt.length() < str.length()) {
            System.out.println("Ошибка. Длина подстроки должна быть меньше, чем длинна вводимой строки");
            return;
        }
        mas[0] = 0;
        if (str.length() < 2) {
            return;
        }
        for (int i = 1; i < str.length(); i++) {
            int index2 = 0;
            for (int j = 1; j <= i; j++) {
                String prefix = str.substring(0, j); // увеличиваем на каждой итерации значение префикса на один символ
                String suffix = str.substring(i + 1 - j, i + 1); // увеличиваем значение суффикса на 1 символ каждую итерацию
                if (prefix.equals(suffix) && (index2 < prefix.length())) {
                    index2 = prefix.length();
                }
            }
            mas[i] = index2;
        }
    }
    //Передаем префикс функцию и и находим индекс символа, с которого начинается нужная нам подстрока в тексте
    public int Morris1(int[] mas) {
        int index = 0;
        while (index < txt.length()) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != txt.charAt(index + i)) {
                    if (i == 0) {
                        index += 1;
                    } else {
                        index += i - mas[i - 1];
                    }
                    break;
                }
                if (i == str.length() - 1) {
                    return index;
                }
            }
        }
        return -1;
    }
    public void vivod(int index) {
        System.out.print(txt.substring(0, index));
        System.out.print("\n'<" + txt.substring(index, index + str.length()) + ">'\n");
        System.out.print(txt.substring(index + str.length()));
    }
}
