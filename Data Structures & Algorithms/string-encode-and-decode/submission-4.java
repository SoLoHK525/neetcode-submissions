class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            int len = s.length();

            sb.append(len + "@A");

            sb.append(s + "@A");
        }

        var res = sb.toString();

        System.out.println("Res: " + res);

        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        String[] tokens = str.split("@A");

        if (str.length() == 0 || tokens.length == 0) {
            return List.of();
        }

        System.out.println("Tokens: " + Arrays.toString(tokens));


        for(int i = 0; i < tokens.length; i++) {
            // parse length
            int len = Integer.parseInt(tokens[i++]);
            StringBuilder sb = new StringBuilder();

            while(sb.length() < len) {
                sb.append(tokens[i]);
                System.out.println("sb: " + sb);
            }

            res.add(sb.toString());
        }

        return res;
    }
}
