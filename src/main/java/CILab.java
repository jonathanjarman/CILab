public class CILab implements CILabInterface {
    private String myString;

    @Override
    public String getString() {
        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public boolean detectCapitalUse() {
        if (myString == null || myString.isEmpty())
            return true;

        boolean allUpperCase = true;
        boolean allLowerCase = true;
        boolean onlyFirstCapital = true;

        for (int i = 0; i < myString.length(); i++) {
            char c = myString.charAt(i);
            if (Character.isLowerCase(c)) {
                allUpperCase = false;
                if (i == 0) {
                    onlyFirstCapital = false;
                }
            } else if (Character.isUpperCase(c)) {
                allLowerCase = false;
                if (i > 0) {
                    onlyFirstCapital = false;
                }
            } else {
                allLowerCase = false;
                allUpperCase = false;
                if (i > 0) {
                    onlyFirstCapital = false;
                }
            }
        }
        return allUpperCase || allLowerCase || onlyFirstCapital;
    }
}

