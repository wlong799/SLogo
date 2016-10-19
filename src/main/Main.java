package main;

import controller.SLogoController;
import model.CommandParser;

public class Main {

    public static void main(String[] args){
            final String WHITESPACE = "\\p{Space}";
            String[] examples = {
                "",
                "# foo",
                "foo #",
                "#",
                "fd 50",
                "FD 50",
                "forwardd",
                "equalp",
                "equal?",
                "equal??",
                "+",
                "lessp 10 20",
                "SuM",
                "-",
                "*",
                "/",
                "%",
                "~",
                "+not",
                "not+",
                "++",
                "+*+",
                "or",
                "FOR",
                "allOrNothing",
                "all_or_nothing",
                "allOr_nothing?",
                "allOr?nothing_",
                ":allornothing",
                "PI",
                "90",
                "9.09",
                "9.0.0",
                "[",
                "]",
                "(",
                ")",
                "[ fd 50 fd 30 ]"
            };
            SLogoController controller = new SLogoController();
            // these are more specific, so add them first to ensure they are checked first
            controller.parseText(examples);
            
    }
}
