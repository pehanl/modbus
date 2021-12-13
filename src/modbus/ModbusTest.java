package modbus;

import de.re.easymodbus.modbusclient.ModbusClient;
import de.re.easymodbus.modbusclient.gui.EasyModbusTCPClientExampleGUI;

public class ModbusTest
{
    public static void main(String[] args)
    {
        ModbusClient modbusClient = new ModbusClient("127.0.0.1",502);
        try
        {
            EasyModbusTCPClientExampleGUI ea = new EasyModbusTCPClientExampleGUI();
            modbusClient.Connect();
            modbusClient.WriteSingleCoil(0, true);
            modbusClient.WriteSingleRegister(0, 1235);
            modbusClient.WriteMultipleRegisters(11, ModbusClient.ConvertFloatToTwoRegisters((float) 123.56));
            System.out.println(modbusClient.ReadCoils(0, 1)[0]);
            System.out.println(modbusClient.ReadHoldingRegisters(0, 1)[0]);
            System.out.println(ModbusClient.ConvertRegistersToFloat(modbusClient.ReadHoldingRegisters(11, 2)));
        }
        catch (Exception e)
        {
        }
    }

}
