class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            // Split into local and domain parts
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex);

            // Rule 1: Handle the '+' sign
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }

            // Rule 2: Handle the '.' sign
            local = local.replace(".", "");

            // Reconstruct and add to set
            uniqueEmails.add(local + domain);
        }

        return uniqueEmails.size();
    }
}