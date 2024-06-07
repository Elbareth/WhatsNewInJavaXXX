package org.example.files;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static java.nio.file.StandardOpenOption.READ;

public class ReadFileUsingVirtualMemory {
    public void readFile()
    {
        try {
            FileChannel fileChannel = FileChannel.open(Path.of("pliczek.txt"), READ);
            //fileChannel.lock(); //we create lock for this file - only for write purpose
            long channelSize = fileChannel.size();
            ByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, channelSize);
            System.out.println(LocalDateTime.now());
            readBuffer(buffer);
            System.out.println(LocalDateTime.now());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readBuffer(ByteBuffer buffer)
    {
        buffer.rewind();
        Charset charset = Charset.forName("ASCII");
        CharBuffer charBuffer = charset.decode(buffer);
        for(int i = 0; i < charBuffer.length(); i++)
        {
            System.out.print(charBuffer.get());
        }
        System.out.println("");
    }
}
