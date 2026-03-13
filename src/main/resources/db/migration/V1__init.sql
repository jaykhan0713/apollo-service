CREATE TABLE users (
    id UUID PRIMARY KEY,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE products (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT,
    token_price INTEGER NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE orders (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE RESTRICT,
    total_tokens INTEGER NOT NULL,
    status TEXT NOT NULL CHECK (status IN ('PENDING', 'COMPLETED', 'CANCELLED')),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE order_items (
    order_id UUID NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
    product_id UUID NOT NULL REFERENCES products(id) ON DELETE RESTRICT,
    quantity INTEGER NOT NULL,
    token_price_at_time INTEGER NOT NULL,
    PRIMARY KEY (order_id, product_id)
);

-- foreign key indexes
CREATE INDEX idx_orders_user_id ON orders(user_id);
CREATE INDEX idx_order_items_product_id ON order_items(product_id);

-- composite index for paginated order history per user
CREATE INDEX idx_orders_user_created ON orders(user_id, created_at);

-- partial index for pending shopping
CREATE INDEX idx_orders_pending ON orders(created_at) WHERE status = 'PENDING';

-- populate tables

INSERT INTO products (id, name, description, token_price)
VALUES
    (gen_random_uuid(), 'Shadowblade', 'A blade forged in darkness', 100),
    (gen_random_uuid(), 'Iron Buckler', 'Dented but reliable', 60),
    (gen_random_uuid(), 'Stormreaver', 'Crackles with lightning on each swing', 95),
    (gen_random_uuid(), 'Leather Pauldrons', 'Light shoulder guards for scouts', 35),
    (gen_random_uuid(), 'Moonveil Cloak', 'Shimmers faintly under moonlight', 55),
    (gen_random_uuid(), 'Worn Dagger', 'Seen better days', 20),
    (gen_random_uuid(), 'Voidreaper', 'Tears through reality itself', 110),
    (gen_random_uuid(), 'Chainmail Vest', 'Standard issue for foot soldiers', 40),
    (gen_random_uuid(), 'Nightwhisper Bow', 'Silent as a shadow at midnight', 65),
    (gen_random_uuid(), 'Cracked Shield', 'Barely holding together', 15),
    (gen_random_uuid(), 'Thornwood Staff', 'Carved from an ancient cursed tree', 45),
    (gen_random_uuid(), 'Emberstrike Hammer', 'Leaves scorch marks on every hit', 120),
    (gen_random_uuid(), 'Rift Crossbow', 'Bolts phase through light armor', 70),
    (gen_random_uuid(), 'Ashen Gauntlets', 'Still warm from the forge', 38),
    (gen_random_uuid(), 'Solaris Crown', 'Radiates blinding golden light', 105),
    (gen_random_uuid(), 'Rusted Axe', 'The rust adds character', 18),
    (gen_random_uuid(), 'Wraithbone Armor', 'Cold to the touch always', 58),
    (gen_random_uuid(), 'Cinder Boots', 'Leave smoldering footprints', 42),
    (gen_random_uuid(), 'Velyn Spellblade', 'Hums with arcane energy', 115),
    (gen_random_uuid(), 'Stormfang Lance', 'Whistles like a gale when thrust', 75),
    (gen_random_uuid(), 'Obsidian Talisman', 'Absorbs minor curses passively', 22),
    (gen_random_uuid(), 'Kaelthas Warblade', 'Belonged to a legendary general', 130),
    (gen_random_uuid(), 'Mira Shortbow', 'Compact and deadly at close range', 48),
    (gen_random_uuid(), 'Dusk Cowl', 'Grants near invisibility at dusk', 62),
    (gen_random_uuid(), 'Frost Pendant', 'Keeps the wearer unnervingly calm', 12),
    (gen_random_uuid(), 'Blazewing Shield', 'Deflects flames back at attackers', 125),
    (gen_random_uuid(), 'Sylvan Quiver', 'Arrows never seem to run out', 68),
    (gen_random_uuid(), 'Ironclad Helm', 'Heavy but nothing gets through', 44),
    (gen_random_uuid(), 'Nether Orb', 'Pulses with an unsettling glow', 25),
    (gen_random_uuid(), 'Aurora Battleaxe', 'Trails ribbons of light mid-swing', 140)