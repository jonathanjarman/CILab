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

        boolean allUpperCase = true; // Flag to track if all letters are uppercase
        boolean allLowerCase = true;  // Flag to track if all letters are lowercase
        boolean onlyFirstCapital = true; // Flag to track if only the first letter is capital

        for (int i = 0; i < myString.length(); i++) {
            char c = myString.charAt(i);
            if (Character.isLowerCase(c)) {
                allUpperCase = false; // Lowercase letter found, not all letters are uppercase
                if (i == 0) {
                    onlyFirstCapital = false;
                }
            } else if (Character.isUpperCase(c)) {
                allLowerCase = false; // Uppercase letter found, not all letters are lowercase
                if (i > 0) {
                    onlyFirstCapital = false;
                }
            } else {
                allLowerCase = false;
                allUpperCase = false;
                if (i > 0) {
                    onlyFirstCapital = false; // Uppercase letter found after the first letter, not only the first letter is capital
                }
            }
        }
        return allUpperCase || allLowerCase || onlyFirstCapital;
    }
}

