package command;

import java.util.Stack;

/**
 *
 * @author HebaHamdan
 */
public class RemoteControl3Undo {
 Command[] onCommands;
	Command[] offCommands;
	Stack<Command> undoCommand;
 
	public RemoteControl3Undo() {
		  onCommands=new Command[7];
          offCommands=new Command[7];
        Command noCommand=new NoCommand();
          for(int i=0;i<7;i++){
          onCommands[i]=noCommand;
          offCommands[i]=noCommand;
          }
          undoCommand=new Stack<Command>();

		// fill code: write all necessary initialization here 
	}
  
	public void setCommand(int slot, Command onCommand, Command offCommand) {
	onCommands[slot]=onCommand;
        offCommands[slot]=offCommand;

		//fill code: 
	}
 
	public void onButtonWasPushed(int slot) {
		  onCommands[slot].execute();
                  undoCommand.push(onCommands[slot]);
	}
 
	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
                undoCommand.push(offCommands[slot]);
	}
 
	public void undoButtonWasPushed() {
            int n=3;
	while(n!=0){
            n--;
            System.out.println(n);
         undoCommand.pop().undo();
        }
           
	}
  
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
				+ "    " + offCommands[i].getClass().getName() + "\n");
		}
		stringBuff.append("[undo] " + undoCommand.getClass().getName() + "\n");
		return stringBuff.toString();
	}

}
