public class TranslateAddr {
        public static void main(String[] args) {
            long page_U;
            long offset_U;
            long address_U = 20221108;

            page_U = address_U >>> 12;
            offset_U = address_U & 0xfff;

            System.out.println("address contains: " + Long.toUnsignedString(address_U) );
            System.out.println("page number: " + Long.toUnsignedString(page_U));
            System.out.println("offset: " + Long.toUnsignedString(offset_U));

        }
    }

