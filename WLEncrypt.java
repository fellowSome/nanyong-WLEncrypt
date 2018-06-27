import weblogic.security.internal.SerializedSystemIni;
import weblogic.security.internal.encryption.ClearOrEncryptedService;
import weblogic.security.internal.encryption.EncryptionService;

public class WLEncrypt {

	static EncryptionService es = null;
	static ClearOrEncryptedService ces = null;

	public static void main(String[] paramArrayOfString) {

		System.out.println("WLEncrypt:===========================");
		String infoStr = null;

		if (paramArrayOfString == null) {
			System.out.println("param array of string is null !");
		} else if (paramArrayOfString.length > 1) {
			String datPath = paramArrayOfString[0];
			es = SerializedSystemIni.getEncryptionService(datPath);
			if (es != null) {
				ces = new ClearOrEncryptedService(es);
				infoStr = paramArrayOfString[1];
			}
		} else {
			System.out.println("param array of string length must more than 1 !");
		}
		if (infoStr != null && ces != null) {
			System.out.println("encrypt result:" + ces.encrypt(infoStr));
			System.out.println("decrypt result:" + ces.decrypt(infoStr));
		}
		System.out.println("WLEncrypt:===========================");
	}
}
