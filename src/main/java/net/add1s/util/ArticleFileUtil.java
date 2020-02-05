package net.add1s.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author pj.w@qq.com
 */
@Component
@Configuration
@PropertySource(value = "classpath:common.properties")
public class ArticleFileUtil {

    @Value("${article.files.path}")
    private String articlesPath;

    public String save(Long id, String data) throws IOException {
        // 构造文章的绝对路径
        Path articlePath = Paths.get(articlesPath, id + ".txt");
        // 创建文件
        Files.createFile(articlePath);
        // 填充内容
        Files.write(articlePath, data.getBytes(StandardCharsets.UTF_8));
        // 返回保存绝对路径
        return articlePath.toString();
    }

    public void update(Long id, String data) throws IOException {
        // 获取原文章存储绝对路径
        Path articlePath = Paths.get(articlesPath, id + ".txt");
        // 修改覆盖文章内容
        Files.write(articlePath, data.getBytes(StandardCharsets.UTF_8));
    }

    public boolean delete(Long id) throws IOException {
        // 获取原文章存储绝对路径
        Path articlePath = Paths.get(articlesPath, id + ".txt");
        // 若文件存在就执行删除操作
        return Files.deleteIfExists(articlePath);
    }

    public String get(Long id) throws IOException {
        // 获取目标文章存储绝对路径
        Path articlePath = Paths.get(articlesPath, id + ".txt");
        // 读取数据并返回
        return new String(Files.readAllBytes(articlePath));
    }

    /*********************************
     * 开发环境下保存在resources目录里
     *********************************/

    private String saveByDev(Long id, String data) throws IOException, URISyntaxException {
        // 获取文章目录绝对路径
        Path articlesPath = Paths.get(ClassLoader.getSystemResource("articles").toURI()).toAbsolutePath();
        // 构造文章的绝对路径
        Path articlePath = Paths.get(articlesPath.toString(), id + ".txt");
        // 创建文件
        Files.createFile(articlePath);
        // 填充内容
        Files.write(articlePath, data.getBytes(StandardCharsets.UTF_8));
        // 返回保存绝对路径
        return articlePath.toString();
    }

    private void updateByDev(Long id, String data) throws URISyntaxException, IOException {
        // 获取文章目录绝对路径
        Path articlesPath = Paths.get(ClassLoader.getSystemResource("articles").toURI()).toAbsolutePath();
        // 获取原文章存储绝对路径
        Path articlePath = Paths.get(articlesPath.toString(), id + ".txt");
        // 修改覆盖文章内容
        Files.write(articlePath, data.getBytes(StandardCharsets.UTF_8));
    }

    private boolean deleteByDev(Long id) throws URISyntaxException, IOException {
        // 获取文章目录绝对路径
        Path articlesPath = Paths.get(ClassLoader.getSystemResource("articles").toURI()).toAbsolutePath();
        // 获取原文章存储绝对路径
        Path articlePath = Paths.get(articlesPath.toString(), id + ".txt");
        // 若文件存在就执行删除操作
        return Files.deleteIfExists(articlePath);
    }

    private String getByDev(Long id) throws URISyntaxException, IOException {
        // 获取文章目录绝对路径
        Path articlesPath = Paths.get(ClassLoader.getSystemResource("articles").toURI()).toAbsolutePath();
        // 获取目标文章存储绝对路径
        Path articlePath = Paths.get(articlesPath.toString(), id + ".txt");
        // 读取数据并返回
        return new String(Files.readAllBytes(articlePath));
    }
}
