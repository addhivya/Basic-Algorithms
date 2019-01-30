package Final;

public class ValidParanthesis {

        public boolean checkValidString(String s) {
            if(s.length()==0)
                return true;
            Boolean f=front(s);
            Boolean b=back(s);
            return f&&b;
        }

        public boolean front(String s)
        {
            int open=0;
            int close=0;
            int astriek=0;
            for(int i=0;i<s.length();i++)
            {
                char c=s.charAt(i);
                if(c=='(')
                    open=open+1;
                if(c==')')
                    close=close+1;
                if(c=='*')
                    astriek=astriek+1;
                if(open+astriek<close)
                    return false;
            }
            if(Math.abs(open-close)<=astriek)
                return true;

            return false;
        }

        public boolean back(String s)
        {
            int open=0;
            int close=0;
            int astriek=0;
            for(int i=s.length()-1;i>=0;i--)
            {
                char c=s.charAt(i);
                if(c=='(')
                    open=open+1;
                if(c==')')
                    close=close+1;
                if(c=='*')
                    astriek=astriek+1;
                if(close+astriek<open)
                    return false;
            }
            if(Math.abs(open-close)<=astriek)
                return true;
            return false;
        }

    public static void main(String[] args) {
        ValidParanthesis valid=new ValidParanthesis();
        String s="(*))";
        System.out.println(valid.checkValidString(s));

    }
}
