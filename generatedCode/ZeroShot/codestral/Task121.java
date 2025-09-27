package ZeroShot.codestral;
@PostMapping("/uploadFile")
public String uploadFile(@RequestParam("file") MultipartFile file) {
    try {
        // save file to a directory
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
        Files.write(path, bytes);
        return "File uploaded successfully!";
    } catch (IOException e) {
        e.printStackTrace();
        return "Error uploading file!";
    }
}