package com.baktajivan;
//imports
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    public boolean Regex (String pattern, String link) {

        Pattern patn = Pattern.compile(pattern);
        Matcher mtr = patn.matcher(link);

        return mtr.find();
    }//regex
}//RegexMatches


/*References
All credits to Sir Zhamri and my fellows friends.

Resource refered to :
https://github.com/zhamri/MyClass-JSoup
https://github.com/vissanuck/256609-STIW3054-A191-A1
https://aboullaite.me/jsoup-html-parser-tutorial-examples/
http://jxls.sourceforge.net/index.html
and many more online resources that i forget the link to it.

 */