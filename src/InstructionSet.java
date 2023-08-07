public class InstructionSet {
    Memory _mem;
    RegisterSet _reg;
    String _M;

    public InstructionSet( Memory m, RegisterSet r ){
        _mem = m;
        _reg = r;
        _M = "";
    }

    private void updateM(){
        _M = _mem.getMemory( Integer.parseInt( _reg.get_H()+_reg.get_L(), 16));
    }

    public void operate( String instruction, int address ){
        switch (instruction) {
            case "MOV A,A" -> _reg.set_A(_reg.get_A());
            case "MOV A,B" -> _reg.set_A(_reg.get_B());
            case "MOV A,C" -> _reg.set_A(_reg.get_C());
            case "MOV A,D" -> _reg.set_A(_reg.get_D());
            case "MOV A,E" -> _reg.set_A(_reg.get_E());
            case "MOV A,H" -> _reg.set_A(_reg.get_H());
            case "MOV A,L" -> _reg.set_A(_reg.get_L());
            case "MOV A,M" -> {
                updateM();
                _reg.set_A(_M);
            }

            case "MOV B,A" -> _reg.set_B(_reg.get_A());
            case "MOV B,B" -> _reg.set_B(_reg.get_B());
            case "MOV B,C" -> _reg.set_B(_reg.get_C());
            case "MOV B,D" -> _reg.set_B(_reg.get_D());
            case "MOV B,E" -> _reg.set_B(_reg.get_E());
            case "MOV B,H" -> _reg.set_B(_reg.get_H());
            case "MOV B,L" -> _reg.set_B(_reg.get_L());
            case "MOV B,M" -> {
                updateM();
                _reg.set_B(_M);
            }

            case "MOV C,A" -> _reg.set_C(_reg.get_A());
            case "MOV C,B" -> _reg.set_C(_reg.get_B());
            case "MOV C,C" -> _reg.set_C(_reg.get_C());
            case "MOV C,D" -> _reg.set_C(_reg.get_D());
            case "MOV C,E" -> _reg.set_C(_reg.get_E());
            case "MOV C,H" -> _reg.set_C(_reg.get_H());
            case "MOV C,L" -> _reg.set_C(_reg.get_L());
            case "MOV C,M" -> {
                updateM();
                _reg.set_C(_M);
            }

            case "MOV D,A" -> _reg.set_D(_reg.get_A());
            case "MOV D,B" -> _reg.set_D(_reg.get_B());
            case "MOV D,C" -> _reg.set_D(_reg.get_C());
            case "MOV D,D" -> _reg.set_D(_reg.get_D());
            case "MOV D,E" -> _reg.set_D(_reg.get_E());
            case "MOV D,H" -> _reg.set_D(_reg.get_H());
            case "MOV D,L" -> _reg.set_D(_reg.get_L());
            case "MOV D,M" -> {
                updateM();
                _reg.set_D(_M);
            }

            case "MOV E,A" -> _reg.set_E(_reg.get_A());
            case "MOV E,B" -> _reg.set_E(_reg.get_B());
            case "MOV E,C" -> _reg.set_E(_reg.get_C());
            case "MOV E,D" -> _reg.set_E(_reg.get_D());
            case "MOV E,E" -> _reg.set_E(_reg.get_E());
            case "MOV E,H" -> _reg.set_E(_reg.get_H());
            case "MOV E,L" -> _reg.set_E(_reg.get_L());
            case "MOV E,M" -> {
                updateM();
                _reg.set_E(_M);
            }

            case "MOV H,A" -> _reg.set_H(_reg.get_A());
            case "MOV H,B" -> _reg.set_H(_reg.get_B());
            case "MOV H,C" -> _reg.set_H(_reg.get_C());
            case "MOV H,D" -> _reg.set_H(_reg.get_D());
            case "MOV H,E" -> _reg.set_H(_reg.get_E());
            case "MOV H,H" -> _reg.set_H(_reg.get_H());
            case "MOV H,L" -> _reg.set_H(_reg.get_L());
            case "MOV H,M" -> {
                updateM();
                _reg.set_H(_M);
            }

            case "MOV L,A" -> _reg.set_L(_reg.get_A());
            case "MOV L,B" -> _reg.set_L(_reg.get_B());
            case "MOV L,C" -> _reg.set_L(_reg.get_C());
            case "MOV L,D" -> _reg.set_L(_reg.get_D());
            case "MOV L,E" -> _reg.set_L(_reg.get_E());
            case "MOV L,H" -> _reg.set_L(_reg.get_H());
            case "MOV L,L" -> _reg.set_L(_reg.get_L());
            case "MOV L,M" -> {
                updateM();
                _reg.set_L(_M);
            }

            case "MOV M,A" -> {
                updateM();
                _M = _reg.get_A();
            }
            case "MOV M,B" -> {
                updateM();
                _M = _reg.get_B();
            }
            case "MOV M,C" -> {
                updateM();
                _M = _reg.get_C();
            }
            case "MOV M,D" -> {
                updateM();
                _M = _reg.get_D();
            }
            case "MOV M,E" -> {
                updateM();
                _M = _reg.get_E();
            }
            case "MOV M,H" -> {
                updateM();
                _M = _reg.get_H();
            }
            case "MOV M,L" -> {
                updateM();
                _M = _reg.get_L();
            }
            case "MOV M,M" -> {
                updateM();
            }



            case "MVI A" -> _reg.set_A( _mem.getMemory(address+1) );
            case "MVI B" -> _reg.set_B( _mem.getMemory(address+1) );
            case "MVI C" -> _reg.set_C( _mem.getMemory(address+1) );
            case "MVI D" -> _reg.set_D( _mem.getMemory(address+1) );
            case "MVI E" -> _reg.set_E( _mem.getMemory(address+1) );
            case "MVI H" -> _reg.set_H( _mem.getMemory(address+1) );
            case "MVI L" -> _reg.set_L( _mem.getMemory(address+1) );
            case "MVI M" -> _M = _mem.getMemory(address+1);



            case "LXI B" -> _reg.set_B( _mem.getMemory(address+2) + _mem.getMemory(address+1) );
            case "LXI D" -> _reg.set_D( _mem.getMemory(address+2) + _mem.getMemory(address+1) );
            case "LXI H" -> _reg.set_H( _mem.getMemory(address+2) + _mem.getMemory(address+1) );
            case "LXI SP" -> _reg.set_SP( _mem.getMemory(address+2) + _mem.getMemory(address+1) );



            case "LDA" -> _reg.set_A( _mem.getMemory( Integer.parseInt(_mem.getMemory(address+2) + _mem.getMemory(address+1), 16 )));
            case "STA" -> _mem.editMemory(Integer.parseInt(_mem.getMemory(address+2) + _mem.getMemory(address+1), 16 ), _reg.get_A());



            case "XCHG" -> {
                _M = _reg.get_D()+_reg.get_E();
                _reg.set_D( _reg.get_H() + _reg.get_L() );
                _reg.set_H( _M );
            }



            case "LHLD" -> {
                int base_address = Integer.parseInt(_mem.getMemory(address+2) + _mem.getMemory(address+1), 16 );
                _reg.set_L(_mem.getMemory( base_address ) );
                _reg.set_H(_mem.getMemory(base_address+1));
            }
            case "SHLD" -> {
                int base_address = Integer.parseInt(_mem.getMemory(address+2) + _mem.getMemory(address+1), 16 );
                _mem.editMemory( base_address, _reg.get_L());
                _mem.editMemory( base_address+1, _reg.get_H());
            }



            case "LDAX B" -> {
                int base_address = Integer.parseInt( _reg.get_B()+_reg.get_C(), 16);
                _reg.set_A(_mem.getMemory(base_address));
            }
            case "LDAX D" -> {
                int base_address = Integer.parseInt( _reg.get_D()+_reg.get_E(), 16);
                _reg.set_A(_mem.getMemory(base_address));
            }
            case "LDAX H" -> {
                int base_address = Integer.parseInt( _reg.get_H()+_reg.get_L(), 16);
                _reg.set_A(_mem.getMemory(base_address));
            }



            case "ADD A" -> {
                String a = _reg.get_A();
                String b = _reg.get_A();
                System.out.println("\n"+a+"\n");
                String sum = Utility.addition( a, b );

                _reg.set_A( sum );
            }




            

        }
        int x = _mem.dequeue() + address;
        _reg.set_PC( Integer.toHexString(x) );
    }
}
