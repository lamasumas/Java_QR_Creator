package Qr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOError;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrManager
{
	public  void writeQRCode(String url,String path, String qrName)
	{
		
		QRCodeWriter writer = new QRCodeWriter();
		int width = 256, height = 256;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		int white = 255 << 16 | 255 << 8 | 255;
	    int black = 0;
	    
		try
		{
			BitMatrix bitMatrix = writer.encode(url , BarcodeFormat.QR_CODE, width, height);
			for (int i= 0; i < width; i++)
				for(int j = 0; j<height; j++)
					image.setRGB(i, j, bitMatrix.get(i,j) ?black : white);
			
		
		try 
		{
			ImageIO.write(image, "jpg", new File(path, qrName+".jpg"));
		}catch(IOException e)
		{
			System.out.println("Error while saving the qr");
			e.printStackTrace();
		}
		}catch (WriterException e)
		{
			System.out.println("Error while creating the qr");
					e.printStackTrace();
		}
		
		
	}

}
