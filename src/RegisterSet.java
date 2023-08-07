public class RegisterSet
{
    private String _A, _F, _B, _C, _D, _E, _H, _L, _PC, _SP;

    public RegisterSet()
    {
        _A = _F = _B = _C = _D = _E = _H = _L = _PC = _SP = "";
    }

    /*********** setters **********/

    public void set_A( String str )
    {
        str = Utility.formatData(str);
        if( str.length() <= 2 ){
            _A = str;
        }
        else if( str.length() <= 4 ){
            _A = str.substring( 0,2 );
            _F = str.substring(2);
        }
    }

    public void set_B( String str )
    {
        if( str.length() == 2 ){
            _B = str;
        }
        else if( str.length() == 4 ){
            _B = str.substring(0,2);
            _C = str.substring(2);
        }
    }

    public void set_C( String str )
    {
        if( str.length() == 2 ){
            _C = str;
        }
    }

    public void set_D( String str )
    {
        if( str.length() == 2 ){
            _D = str;
        }
        else if( str.length() == 4 ){
            _D = str.substring(0,2);
            _E = str.substring(2);
        }
    }

    public void set_E(String str )
    {
        if( str.length() == 2 ){
            _E = str;
        }
    }

    public void set_H( String str )
    {
        if( str.length() == 2 ){
            _H = str;
        }
        else if( str.length() == 4 ){
            _H = str.substring(0,2);
            _L = str.substring(2);
        }
    }

    public void set_L( String str )
    {
        if( str.length() == 2 ){
            _L = str;
        }
    }

    public void set_PC( String str )
    {
        _PC = str;
    }

    public void set_SP( String str )
    {
        _SP = str;
    }

    public void set_F( String str )
    {
        if( str.length() == 2 ){
            _F = str;
        }
    }

    /***** getters *****/

    String get_A(){
        return _A;
    }
    String get_F(){
        return _F;
    }
    String get_B(){
        return _B;
    }
    String get_C(){
        return _C;
    }
    String get_D(){
        return _D;
    }
    String get_E(){
        return _E;
    }
    String get_H(){
        return _H;
    }
    String get_L(){
        return _L;
    }
    String get_SP(){
        return _SP;
    }
    public String get_PC() {
        return _PC;
    }
}
