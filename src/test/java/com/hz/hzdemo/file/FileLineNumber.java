package com.hz.hzdemo.file;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

/**
 * Create by zhoumingbing on 2019-09-16
 */
public class FileLineNumber {

    private static final String WC_FILE_LINE_PATTERN = "wc -l {0}";

    private static final String WC_OUTPUT_FIRST = " | awk '{print $1}'";

    private static final String BIN_SH = "/bin/sh";

    private static final String SHELL_C = "-c";

    private static final int EXECUTE_SHELL_TIMOUT = 15;

    @Test
    public void test() throws IOException {
        System.out.println(readFileLine("/Users/haizhi/Desktop/company.json"));
    }

    private int readFileLine(String fileName) throws IOException {
        int count = readFileByShell(fileName);
        if (count < 0) {
            count = readFileByLineNumberReader(fileName);
        }
        return count;
    }

    public static int readFileByLineNumberReader(String fileName) throws IOException {
        try (LineNumberReader lineReader = new LineNumberReader(new FileReader(new File(fileName)))) {
            lineReader.skip(Long.MAX_VALUE);
            return lineReader.getLineNumber() + 1;
        }
    }

    private int readFileByShell(String fileName) {
        int count = -1;
        String command = MessageFormat.format(WC_FILE_LINE_PATTERN, fileName) + WC_OUTPUT_FIRST;
        String[] cmd = {BIN_SH, SHELL_C, command};
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            if (process.waitFor(EXECUTE_SHELL_TIMOUT, TimeUnit.MINUTES)) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line = reader.readLine();
                    if (StringUtils.isNotBlank(line)) {
                        count = Integer.parseInt(line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
