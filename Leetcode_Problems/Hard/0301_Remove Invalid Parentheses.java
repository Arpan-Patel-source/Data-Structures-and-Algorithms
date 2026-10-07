public class Solution {
    public List<String> removeInvalidParentheses(String originalText)
    {
        int badOpenCount = 0;
        int badCloseCount = 0;
        for (char character : originalText.toCharArray())
        {
            if (character == '(') badOpenCount++;
            else if (character == ')') {
                if (badOpenCount > 0) badOpenCount--;
                else badCloseCount++;
            }
        }

        HashSet<String> validAnswers = new HashSet<>();

        findCombinations(originalText, 0, badOpenCount, badCloseCount, 0, "", validAnswers);

        return new ArrayList<>(validAnswers);
    }

    private void findCombinations(String originalText, int currentIndex, int openDeletionsLeft, int closeDeletionsLeft, int openBracketsBalance, String builtString, Set<String> validAnswers)
    {
        if (openBracketsBalance < 0) return;

        if (currentIndex == originalText.length()) {
            if (openDeletionsLeft == 0 && closeDeletionsLeft == 0 && openBracketsBalance == 0) validAnswers.add(builtString);
            return;
        }
        char currentCharacter = originalText.charAt(currentIndex);
        if (currentCharacter == '(') {
            if (openDeletionsLeft > 0) {
                findCombinations(originalText, currentIndex + 1, openDeletionsLeft - 1, closeDeletionsLeft, openBracketsBalance, builtString, validAnswers);
            }
            findCombinations(originalText, currentIndex + 1, openDeletionsLeft, closeDeletionsLeft, openBracketsBalance + 1, builtString + currentCharacter, validAnswers);

        } else if (currentCharacter == ')') {
            if (closeDeletionsLeft > 0) {
                findCombinations(originalText, currentIndex + 1, openDeletionsLeft, closeDeletionsLeft - 1, openBracketsBalance, builtString, validAnswers);
            }
            findCombinations(originalText, currentIndex + 1, openDeletionsLeft, closeDeletionsLeft, openBracketsBalance - 1, builtString + currentCharacter, validAnswers);

        } else {
            findCombinations(originalText, currentIndex + 1, openDeletionsLeft, closeDeletionsLeft, openBracketsBalance, builtString + currentCharacter, validAnswers);
        }
    }
}
