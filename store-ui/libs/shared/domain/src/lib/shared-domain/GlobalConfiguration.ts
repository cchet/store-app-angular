export const globalConfiguration = {
  navLinks: {
    home: {
      i18n: 'nav.home',
      uri:
        'home'
    },
    products: {
      i18n: 'nav.products',
      uri:
        'products'
    },
    orders: {
      i18n: 'nav.orders',
      uri:
        'orders'
    },
    cart: {
      i18n: 'nav.cart',
      uri:
        'cart'
    }
  },
  innerLinks: {
    productDetail: {
      routeURI: 'product/:id',
      routeLink: (productId: string): string => `/product/${productId}`
    },
    payment: {
      routeURI: 'payment/:id',
      routeLink: (paymentId: string): string => `/payment/${paymentId}`
    }
  }
};