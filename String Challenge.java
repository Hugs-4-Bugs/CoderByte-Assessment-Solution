import java.util.*;

class Main {

  private static final String CHALLENGE_TOKEN = "peu28x9w3";

  public static String StringChallenge(String str) {
    Stack<String> stack = new Stack<>();
    Set<String> tags = new HashSet<>(Arrays.asList("b", "i", "em", "div", "p"));

    int i = 0;
    while (i < str.length()) {
      if (str.charAt(i) == '<') {
        int end = str.indexOf('>', i);
        if (end == -1) {
          return str; // Error in the HTML-like string
        }

        String tag = str.substring(i + 1, end);
        if (tag.startsWith("/")) {
          tag = tag.substring(1);
          if (stack.isEmpty() || !tags.contains(tag) || !stack.peek().equals(tag)) {
            // Return the first tag causing the issue
            return stack.isEmpty() ? tag : stack.peek();
          }
          stack.pop();
        } else {
          if (!tags.contains(tag)) {
            return str; // Invalid tag
          }
          stack.push(tag);
        }
        i = end;
      }
      i++;
    }

    // If there are unmatched tags in the stack, return the top tag
    if (!stack.isEmpty()) {
      return stack.peek();
    }

    return "true";
  }

  private static String replaceTokenCharacters(String s, String token) {
    for (char c : token.toCharArray()) {
      s = s.replace(Character.toString(c), "--" + c + "--");
    }
    return s;
  }

  public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    String input = s.nextLine();
    String result = StringChallenge(input);
    System.out.print(replaceTokenCharacters(result, CHALLENGE_TOKEN));
    s.close();
  }
}
