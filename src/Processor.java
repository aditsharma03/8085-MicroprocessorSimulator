import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Processor {
    RegisterSet _reg;
    Memory _mem;


    public Processor() {
        _reg = new RegisterSet();
        _mem = new Memory();
    }


    public void assembleMode() {
        System.out.print("Enter start address: ");
        Scanner sc = new Scanner(System.in);
        String hex_address = sc.next();
        sc.nextLine();
        int address = Integer.parseInt(hex_address, 16);
        System.out.println("Send EOF to stop");

            boolean flag = true;
            while ( flag ) {

                try{

                String instruction = Utility.getInstructionFromCLI( hex_address );

                StringTokenizer st = new StringTokenizer(instruction, " ,");
                int num = st.countTokens();
                if (num == 0) {
                    address++;
                    hex_address = Integer.toHexString(address);
                    continue;
                }

                String instruction_data = instruction.substring( instruction.indexOf(' ')+1);
                int len = instruction_data.length(), size = 1;
                for( int i=2; i<=len; i++ ){
                    if( Utility.isHexData( instruction_data.substring( i-2, i))) {
                        size++;
                        ++i;
                    }
                }
                _mem.enqueue( size );
                if( size == 1 ){
                    _mem.editMemory( address++, instruction );
                }
                else if( size == 2  && num == 2 ){
                    _mem.editMemory( address++, st.nextToken());
                    _mem.editMemory( address++, st.nextToken());
                }
                else if( size == 2 && num == 3 ){
                    _mem.editMemory( address++, st.nextToken()+" "+st.nextToken());
                    _mem.editMemory( address++, st.nextToken());
                }
                else if( size == 3 && num == 2 ){
                    _mem.editMemory( address++, st.nextToken());
                    String operand = st.nextToken();
                    _mem.editMemory( address++, operand.substring(2));
                    _mem.editMemory( address++, operand.substring( 0, 2));
                }
                else if( size == 3 && num == 3 ){
                    _mem.editMemory( address++, st.nextToken()+" "+st.nextToken());
                    String operand = st.nextToken();
                    _mem.editMemory( address++, operand.substring(2));
                    _mem.editMemory( address++, operand.substring( 0, 2 ));
                }
                else{
                    System.out.println("Invalid Instruction");
                    System.exit(0);
                }
                hex_address = Integer.toHexString(address);
            }
                catch (NoSuchElementException ignored) {
                    flag = false;
                }
        }
    }


    public void executeMode()
    {
        System.out.print("Enter start address: ");
        Scanner sc = new Scanner(System.in);
//        _reg.set_PC( sc.next() );
//        sc.nextLine();

        _reg.set_PC( "2000" );
        int address = Integer.parseInt( _reg.get_PC(), 16);

        InstructionSet obj = new InstructionSet(_mem, _reg);
        String data = _mem.getMemory(address);
        while( !( data.equalsIgnoreCase("hlt")) ){
            obj.operate( data, address );

            address = Integer.parseInt( _reg.get_PC(), 16);
            data = _mem.getMemory(address);
        }

    }

    public static void main(String[] args) {

        Processor obj = new Processor();
        obj.assembleMode();

        obj._reg.set_A("0A");
        obj._reg.set_B("0B");
        obj._mem.editMemory( Integer.parseInt("2050", 16), "FF");

        obj.executeMode();

        int i = Integer.parseInt("2000", 16);
        for (int x = 0; x <= 16; x++, i++) {
            System.out.println(obj._mem.getMemory(i));
        }
        System.out.println( obj._reg.get_A());
        System.out.println( obj._reg.get_B());
        System.out.println( obj._reg.get_C());
        System.out.println( obj._reg.get_SP());
        System.out.println( obj._mem.getMemory(Integer.parseInt("2050", 16)));
    }
}