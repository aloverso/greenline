import { Selector } from 'testcafe';

fixture `Stations`
    .page `http://localhost:3000`;

test('Should display a station', async t => {
    await t
        .expect(Selector('[data-station]').innerText).eql('Grand Central - 42 St');
});