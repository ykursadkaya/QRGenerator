import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Generator
{

	public static void main(String[] args)
	{

		for (int i = 1000; i<9999; i++)
		{
			try
			{
				String str = String.valueOf(i);
				File file = QRCode.from(str).withSize(2000,2000)
						.withErrorCorrection(ErrorCorrectionLevel.H)
						.to(ImageType.PNG)
						.file(str + ".png");
				BufferedImage qrim = ImageIO.read(file);
				Graphics2D gr = qrim.createGraphics();
				Font font = new Font("Arial", Font.BOLD, 100);
				FontMetrics metrics = gr.getFontMetrics(font);
				int x = 0 + ((2000 - 0 - metrics.stringWidth(str)))/2;
				gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				gr.setColor(Color.BLACK);
				gr.setFont(font);
				gr.drawString(str, x, 1925);
				gr.dispose();

				ImageIO.write(qrim, "png", new File(str + ".png"));

			}
			catch (Exception ex)
			{
				System.out.println(ex);
			}
		}
	}

}
