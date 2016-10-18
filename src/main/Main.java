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
                "fd",
                "FD",
                "forwardd",
                "equalp",
                "equal?",
                "equal??",
                "+",
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
                ")"
            };
            SLogoController controller = new SLogoController();
            // these are more specific, so add them first to ensure they are checked first
            controller.parseText(examples);
            
    }
}
